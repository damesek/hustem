# HuStem: the hungarian stemmer

WIP

HuStem created for work with Snowball .sbl files.
Goal is upadate the quality of the Hungarian stemmer config file.
Therefore we wrote first we tried find the issues and in this way the tests (TDD workflow).

## Snowball cli basics

Test the new Hungarian Snowball SBL file from Snowball root folder 
(src/resources/snowball-master)

```bash
make && echo "baglyokat" | ./stemwords -l hungarian
```

The hungarian words dict to check the results
```bash 
grep "teremt" ../magyar-szavak.txt
```

## Compile the Java sources

Todo: add as prep-task

```bash
clj -T:build clean
clj -T:build compile-java
```




## License

Copyright © 2023 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.