mkdir build

javac ./src/model/*.java -d ./build -encoding utf-8
javac -cp ./src ./src/controller/*.java -d ./build -encoding utf-8
javac -cp ./src ./test/test/*.java -d ./build -encoding utf-8

chcp 65001

cd build
java test.MainTesterClass