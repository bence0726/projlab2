mkdir build
mkdir build\test\testfiles
copy test\testfiles build\test\testfiles

javac .\src\model\*.java -d .\build -encoding utf-8
javac -cp .\src .\src\controller\*.java -d .\build -encoding utf-8
javac -cp .\src .\test\test\*.java -d .\build -encoding utf-8

chcp 65000

cd build
