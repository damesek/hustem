# HuStem: the hungarian stemmer

WIP



HuStem was created to work with Snowball's .sbl files.
The goal is to update the quality of the Hungarian stemmer config file.
To achieve this, I first try to identify the issues and then proceed with tests, following a TDD (Test-Driven Development) workflow.

## Error rate: 

```clojure
{:hunspell 32,91%, :snowball 47,41%, :hunspell-mdb 32,91%}
```
This means Hunspell is 27% more accurate than Snowball.
I tested two different dic/aff sources, but there was no difference in efficiency.

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
