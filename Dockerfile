FROM jenkins/jenkins:lts

USER root

RUN apt-get update && \
    apt-get install -y jq curl unzip && \
    apt-get clean

USER jenkins
