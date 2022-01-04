#!/usr/bin/env bash

docker build -t fatnieva/service-courses:latest service-courses/
docker push fatnieva/service-courses

docker build -t fatnieva/service-language-classes:latest service-language-classes/
docker push fatnieva/service-language-classes

docker build -t fatnieva/service-users:latest service-users/
docker push fatnieva/service-users

minikube stop && minikube delete
minikube start

kubectl apply -f service-courses/workloads.yaml
kubectl apply -f service-language-classes/workloads.yaml
kubectl apply -f service-users/workloads.yaml

echo "$(minikube ip)"