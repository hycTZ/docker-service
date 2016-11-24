docker run -d --name zookeeper --publish 2181:2181 \
--volume /etc/localtime:/etc/localtime \
zookeeper:latest

docker run -d --name rabbitmq \
 --publish 5671:5671 \
 --publish 5673:5672 \
 --publish 4369:4369 \
 --publish 25672:25672 \
 --publish 15671:15671 \
 --publish 15672:15672 \
 rabbitmq:management

docker run -d --name mongodb --volume /mongodb/data:/data/db \
 --publish 27017:27017 \
 mongo:3.2.11

echo 'sleep 20s to next step...'
sleep 20s

docker run -d --name kafka --publish 9092:9092 \
--link zookeeper \
--env KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 \
--env KAFKA_ADVERTISED_HOST_NAME=10.47.160.238 \
--env KAFKA_ADVERTISED_PORT=9092 \
--volume /etc/localtime:/etc/localtime \
wurstmeister/kafka:latest

docker run -d --name mongo-express --link mongodb:mongo \
 --publish 8081:8081 \
 mongo-express:0.32.0

echo 'sleep 20s to next step...'
sleep 20s

docker run -d --name service-registry-demo --publish 8000:8000 \
 --volume /etc/localtime:/etc/localtime \
 registry.cn-hangzhou.aliyuncs.com/ztecs/service-registry-demo:docker-demo-3.0

echo 'sleep 30s to next step...'
sleep 30s

docker run -d --name config-server-demo --link service-registry-demo:service-registry \
 --volume /etc/localtime:/etc/localtime \
 registry.cn-hangzhou.aliyuncs.com/ztecs/config-server-demo:docker-demo-3.0

echo 'sleep 30s to next step...'
sleep 30s

docker run -d --name add-service-demo --link service-registry-demo:service-registry \
 --link config-server-demo \
 --volume /etc/localtime:/etc/localtime \
 registry.cn-hangzhou.aliyuncs.com/ztecs/add-service-demo:docker-demo-3.0

docker run -d --name service-gateway-demo --publish 80:80 --link service-registry-demo:service-registry \
 --link config-server-demo \
 --link add-service-demo --volume /etc/localtime:/etc/localtime \
 registry.cn-hangzhou.aliyuncs.com/ztecs/service-gateway-demo:docker-demo-3.0

docker run -d --name log-persist-demo --link service-registry-demo:service-registry \
 --link config-server-demo \
 --link kafka --link mongodb  \
 --volume /etc/localtime:/etc/localtime \
 registry.cn-hangzhou.aliyuncs.com/ztecs/log-persist-demo:docker-demo-3.0