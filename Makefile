SERVICE_NAME=auth

init:
	spring init \
		--build gradle \
		--dependencies=cloud-stream,rabbitmq \
		--description "ticketing service" \
		-g com.ticketing \
		-j 11 \
		-n ${SERVICE_NAME} \
		-p jar \
		${SERVICE_NAME}

build_gradle:
	cd ${SERVICE_NAME} && ./gradlew build

build_image:
	cd ${SERVICE_NAME} && gcloud builds submit \
		--tag gcr.io/ticketing-333617/ticketing-${SERVICE_NAME}