
SERVICE_NAME=gateway
init:
	spring init \
		--build gradle \
		--dependencies=cloud-gateway,webflux,cloud-eureka \
		--description "ticketing service" \
		-g com.ticketing \
		-j 11 \
		-n ${SERVICE_NAME} \
		-p jar \
		${SERVICE_NAME}