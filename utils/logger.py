#!/usr/bin/python3

import subprocess
import re
from threading import Thread

LOG_FILE="ticketing.log"

# get pods
print("#### GETTING PODS...")
cmd = "kubectl get pods"
pods = subprocess.run(cmd, 
    shell=True, 
    capture_output=True,
    text=True).stdout

pods = re.sub(" |\n", "@", pods)
pods = re.sub("@+", "@", pods).split("@")
pods = [pods[i] for i in range(5, len(pods) - 1, 5)]
print("#### PODS: ")
for pod in pods:
    print(pod)

# log all pods
print("#### LOGGING... ")
use_filter = False
GREP_FILTER="auth"
subprocess.run(f"rm {LOG_FILE}", shell=True)
def log_pod(pod: str):
    with open(LOG_FILE, "a") as f:
        cmd = f"kubectl logs -f {pod} --since=30m | sed -e 's/^/[{pod}] /'"
        if use_filter:
            cmd += "| grep -E {GREP_FILTER}"
        subprocess.run(cmd, 
            shell=True, 
            stdout=f,
            text=True)
threads = []
for pod in pods:
    t = Thread(target=log_pod, args=[pod])
    t.setDaemon(True)
    t.start()
    threads.append(t)
for t in threads:
    t.join()