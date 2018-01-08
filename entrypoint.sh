#!/bin/bash

export EC2_HOST_IP=`curl -s http://169.254.169.254/latest/meta-data/local-ipv4`
export SPRING_CLOUD_CONSUL_DISCOVERY_IPADDRESS=$EC2_HOST_IP

echo "JVM_OPTS="$JVM_OPTS
echo "server.port="$SERVER_PORT
echo "spring.profiles.active="$SPRING_PROFILES_ACTIVE
echo "spring.cloud.consul.host="$SPRING_CLOUD_CONSUL_HOST
echo "spring.cloud.consul.port="$SPRING_CLOUD_CONSUL_PORT
echo "spring.cloud.consul.enabled="$SPRING_CLOUD_CONSUL_ENABLED
echo "spring.cloud.consul.discovery.enabled="$SPRING_CLOUD_CONSUL_DISCOVERY_ENABLED
echo "spring.cloud.consul.discovery.register="$SPRING_CLOUD_CONSUL_DISCOVERY_REGISTER
echo "spring.cloud.consul.discovery.registerhealthcheck="$SPRING_CLOUD_CONSUL_DISCOVERY_REGISTERHEALTHCHECK
echo "spring.cloud.consul.discovery.healthcheckinterval="$SPRING_CLOUD_CONSUL_DISCOVERY_HEALTHCHECKINTERVAL
echo "spring.cloud.consul.discovery.healthCheckTimeout="$SPRING_CLOUD_CONSUL_DISCOVERY_HEALTHCHECKTIMEOUT
echo "spring.cloud.consul.discovery.healthCheckCriticalTimeout="$SPRING_CLOUD_CONSUL_DISCOVERY_HEALTHCHECKCRITICALTIMEOUT
echo "spring.cloud.consul.discovery.prefer-ip-address="$SPRING_CLOUD_CONSUL_DISCOVERY_PREFER_IP_ADDRESS
echo "spring.cloud.consul.discovery.ipAddress="$SPRING_CLOUD_CONSUL_DISCOVERY_IPADDRESS
echo ""
java $JVM_OPTS -jar /app.jar