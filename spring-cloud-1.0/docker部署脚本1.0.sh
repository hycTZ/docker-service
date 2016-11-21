docker run -d --name service-registry-demo --publish 8000:8000 \
 --volume /etc/localtime:/etc/localtime \
 registry.cn-hangzhou.aliyuncs.com/ztecs/service-registry-demo:docker-demo-1.0

echo 'sleep 30s to next step...'
sleep 30s

docker run -d --name add-service-demo --link service-registry-demo:service-registry \
 --volume /etc/localtime:/etc/localtime \
 registry.cn-hangzhou.aliyuncs.com/ztecs/add-service-demo:docker-demo-1.0

docker run -d --name service-gateway-demo --publish 80:80 --link service-registry-demo:service-registry \
 --link add-service-demo --volume /etc/localtime:/etc/localtime \
 registry.cn-hangzhou.aliyuncs.com/ztecs/service-gateway-demo:docker-demo-1.0
