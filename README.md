# Java-Reactive-Programming
This repository is all about reactive programming in java

# Explore Mono class
In the package called `MonoPractice` you can find simple tasks describing how Mono class works. </br>
Also check out the jpg file called `MonoTable` and treat it as a cheat sheet.

# Mono class assignment
In this assignment we are creating simple `FileService`. </br>
Service is responsible for : </br>
- `Reading file and returning content of it` </br>
- `Creating file and writing content` </br>
- `deleting files` </br>

We expect the service to work only when `subscribed`. </br>
Another expectation is to communicate with user in terms of errors.


# Explore Flux class
In the package called `FluxPractice` you can find simple tasks describing how Mono class works. </br>
Also check out the jpg file called `FluxTable` and treat it as a cheat sheet.

# Flux class assignment
In this assignment we are creating `Stock market observer`. </br>
Our service should be responsible for generating random stock movement and emit the values </br>
to the subscribers. In addition when stock reaches it's `ATH` or `ATL` that are set by user </br>
program should shut down itself.
