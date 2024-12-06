FILES = $(wildcard src/*.java)
TEST = CoinboxTest

JAVALIBS := .:/usr/share/java/junit.jar
JAVALIBS := $(JAVALIBS):/usr/share/java/hamcrest-core.jar
JAVALIBS := $(JAVALIBS):/usr/share/java/hamcrest-generator.jar
JAVALIBS := $(JAVALIBS):/usr/share/java/hamcrest-integration.jar
JAVALIBS := $(JAVALIBS):/usr/share/java/hamcrest-library.jar

.PHONY: build
build:
	@ javac -cp $(JAVALIBS) $(FILES)

.PHONY: test
test:
	@ cd src && java -cp $(JAVALIBS) org.junit.runner.JUnitCore $(TEST)
