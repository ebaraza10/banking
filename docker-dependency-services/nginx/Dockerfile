FROM nginx:alpine

#RUN rm /etc/nginx/conf.d/default.conf
COPY nginx.conf /etc/nginx/conf.d
# COPY nginx.conf /etc/nginx/conf.d/default.conf
# COPY nginx.conf /etc/nginx/conf.d/
# COPY nginx.conf /etc/nginx/nginx.conf
#ADD nginx.conf /etc/nginx/nginx.conf
# ADD nginx.conf /etc/nginx/conf.d/nginx.conf
#####RUN mkdir -p /etc/ssl_certificates
# COPY nginx.conf /etc/nginx/conf.d
RUN apk add busybox-extras
RUN apk add nano
#COPY cert.pem  chain.pem  fullchain.pem  privkey.pem /etc/ssl_certificates/
#######COPY ssl_certificates/* /etc/ssl_certificates/
#/COPY /etc/letsencrypt/live/insofts1.blockchain-in-action.com-0003 /etc/ssl_certificates
####COPY ssl_certificates/fullchain.pem /etc/nginx
####COPY ssl_certificates/privkey.pem /etc/nginx
CMD ["nginx", "-g", "daemon off;"]