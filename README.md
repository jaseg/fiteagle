FITeagle | Future Internet Testbed Experimentation and Management Framework 
===========================================================================

Bootstrap (install & run)
-------------------------
```
curl https://raw.githubusercontent.com/tubav/fiteagle/master/src/main/bin/bootstrap.sh | bash
```

Test
----
```
./src/main/bin/fiteaglectl test
```

Start
-----
```
./src/main/bin/fiteaglectl start
```

Further Information
-------------------
For further information please have a look at [http://fiteagle.org](http://fiteagle.org).

FAQ
---
* Q: FITeagle tests seem to hang while testing cryptography methods on Linux
* A: Setup rng-tools (it should e.g. use /dev/urandom)
