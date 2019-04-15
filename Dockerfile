FROM airhacks/glassfish
COPY ./target/learning.war ${DEPLOYMENT_DIR}
