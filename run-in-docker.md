## Docker image

```
docker run -it -p 4040:4040 -p 8080:8080 -p 8081:8081 -h spark --name=spark p7hb/docker-spark
```

Image description is here:
https://hub.docker.com/r/p7hb/docker-spark

Assemble and run through `spark-submit`:
```
spark-submit --jars /tmp/spark-examples-assembly-1.0.jar --class SparkWordCount /tmp/data/*.txt
```