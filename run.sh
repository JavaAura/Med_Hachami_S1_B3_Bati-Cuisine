#!/bin/bash

# Define variables for paths
JAVA_HOME="/usr/lib/jvm/jdk-22-oracle-x64"
IDEA_AGENT="/home/mhachami/Downloads/ideaIC-2024.2.0.2/idea-IC-242.20224.419/lib/idea_rt.jar"
IDEA_BIN="/home/mhachami/ideaIC-2024.2.0.2/idea-IC-242.20224.419/bin"
PROJECT_DIR="/home/mhachami/Desktop/projects/A2_brief/Med_Hachami_S1_B3_Bati-Cuisine"
# SRC_DIR="$PROJECT_DIR/src"
CLASS_DIR="$PROJECT_DIR/out/production/Bati-Cuisine"
LIB_DIR="$PROJECT_DIR/lib"
PSQL="/usr/share/java/postgresql-42.7.4.jar"
MAIN_CLASS="com.baticuisine.Main"
LOGBACK_CONFIG="$PROJECT_DIR/com/baticuisine/logback.xml"

# Define the Java compiler and runtime
JAVA="$JAVA_HOME/bin/java"
JAVAC="$JAVA_HOME/bin/javac"

# Java runtime options
JAVA_OPTS="-javaagent:$IDEA_AGENT=45221:$IDEA_BIN \
           -Dfile.encoding=UTF-8 \
           -Dsun.stdout.encoding=UTF-8 \
           -Dsun.stderr.encoding=UTF-8"

# Compilation options
CLASSPATH="$PSQL:$LIB_DIR/slf4j-api-2.0.9.jar:$LIB_DIR/logback-classic-1.4.9.jar:$LIB_DIR/logback-core-1.4.9.jar"
COMPILE_OPTS="-d $CLASS_DIR -classpath $CLASSPATH"

# Create the necessary directories if they don't exist
mkdir -p $CLASS_DIR

# Compile all Java files in the project
echo "Compiling Java files..."
$JAVAC $COMPILE_OPTS $(find $SRC_DIR -name "*.java")

cp "$LOGBACK_CONFIG" "$CLASS_DIR/"
echo "logback.xml copied to CLASS_DIR."

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "Compilation successful."
else
    echo "Compilation failed."
    exit 1
fi

# Run the compiled classes directly
echo "Running compiled classes..."
$JAVA $JAVA_OPTS -classpath "$CLASS_DIR:$CLASSPATH" $MAIN_CLASS

# Check if the program ran successfully
if [ $? -eq 0 ]; then
    echo "Program ran successfully."
else
    echo "Failed to run the program."
    exit 1
fi

# Clean up generated files
echo "Cleaning up generated class files..."
rm -rf "$CLASS_DIR"

echo "Cleanup completed."
