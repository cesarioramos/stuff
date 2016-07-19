FROM agilix/java8
MAINTAINER Cesario Ramos <cesario@agilix.nl>

ENV GRADLE_VERSION 2.9

WORKDIR /usr/bin

RUN apt-get install curl
RUN apt-get install zip unzip

RUN curl -sLO https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-all.zip && \
  unzip gradle-${GRADLE_VERSION}-all.zip && \
  ln -s gradle-${GRADLE_VERSION} gradle && \
  rm gradle-${GRADLE_VERSION}-all.zip

ENV GRADLE_HOME /usr/bin/gradle
ENV PATH $PATH:$GRADLE_HOME/bin

WORKDIR /myvol
RUN /bin/bash

