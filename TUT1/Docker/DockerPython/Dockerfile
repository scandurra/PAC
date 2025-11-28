# Use an official Python runtime as a parent image
# This line specifies the base image we'll use. 
# We're using an official lightweight Python 3.9 image based on Debian Buster.
FROM python:3.9-slim-buster

# Set the working directory in the container to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
COPY . /app

# Install any dependencies (in this case, none)
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt

# Make the script executable (not strictly necessary for this simple example)
# RUN chmod +x docker1.py

# Define the command to run the application
CMD ["python", "docker1.py"]