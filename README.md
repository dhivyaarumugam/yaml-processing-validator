# yaml-validate
Demo app to demonstrate YamlProcessor issues

## Installation

```
mvn clean install
```
## Running

```
mvn spring-boot:run
```

## Sample yaml

This can be modified here [sample.yaml](https://github.com/dhivyaarumugam/yaml-processing-validator/blob/master/src/main/resources/sample.yaml)

```
hello: world
arrayAsArray: ['a', 'b']
emptyString: ""
arrayAsString: "[a,b,c]"
emptyArray: []
emptyElementArray: [""]
```

## Endpoints

```
$ curl http://localhost:8080/get
arrayAsArray[0]:a {valueInstanceOf=class java.lang.String}

arrayAsArray[1]:b {valueInstanceOf=class java.lang.String}

arrayAsString:[a,b,c] {valueInstanceOf=class java.lang.String}

emptyArray: {valueInstanceOf=class java.lang.String}

emptyElementArray[0]: {valueInstanceOf=class java.lang.String}

emptyString: {valueInstanceOf=class java.lang.String}

hello:world {valueInstanceOf=class java.lang.String}

```
## Inference

It is clear that the emptyArray element is returned as a 
single string object unlike other Array objects where 
indexing for the collection is being done
