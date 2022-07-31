FROM alpine:latest

# set work directory
ENV APP_HOME=/usr/src/app
RUN mkdir -p /usr/src/app
WORKDIR ${APP_HOME}
ADD . ${APP_HOME}

RUN apk update
RUN apk add openjdk17

RUN apk add tzdata
# Set timezome
ENV TZ="Africa/Nairobi"

