mkdir build
cd src
javac -d cn/edu/lnu/calculatlib/*.java -d ../build/
javac -d cn/edu/lnu/calculatlib/Number/*.java -d ../build/
cd ../build
jar -cvf Cal4Programmer_kernel.jar *
cd ..