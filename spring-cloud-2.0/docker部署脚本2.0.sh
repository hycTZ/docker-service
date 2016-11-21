docker run -d --name service-registry-demo --publish 8000:8000 \
 --volume /etc/localtime:/etc/localtime \
 registry.cn-hangzhou.aliyuncs.com/ztecs/service-registry-demo:docker-demo-2.0

docker run -d --name rabbitmq \
 --publish 5671:5671 \
 --publish 5673:5672 \
 --publish 4369:4369 \
 --publish 25672:25672 \
 --publish 15671:15671 \
 --publish 15672:15672 \
 rabbitmq:management

echo 'sleep 30s to next step...'
sleep 30s

docker run -d --name config-server-demo --link service-registry-demo:service-registry \
 --volume /etc/localtime:/etc/localtime \
 registry.cn-hangzhou.aliyuncs.com/ztecs/config-server-demo:docker-demo-2.0

echo 'sleep 30s to next step...'
sleep 30s

docker run -d --name add-service-demo --link service-registry-demo:service-registry \
 --link config-server-demo \
 --volume /etc/localtime:/etc/localtime \
 registry.cn-hangzhou.aliyuncs.com/ztecs/add-service-demo:docker-demo-2.0

docker run -d --name service-gateway-demo --publish 80:80 --link service-registry-demo:service-registry \
 --link config-server-demo \
 --link add-service-demo --volume /etc/localtime:/etc/localtime \
 registry.cn-hangzhou.aliyuncs.com/ztecs/service-gateway-demo:docker-demo-2.0