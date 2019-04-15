# Build
mvn clean package && docker build -t test/learning .

# RUN

docker rm -f learning || true && docker run -d -p 8080:8080 -p 4848:4848 --name learning test/learning 