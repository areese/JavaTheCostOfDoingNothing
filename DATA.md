



=== Java Benchmark:
```
java -Djava.library.path=target/native/x86_64-linux-gcc/ -jar target/JavaTheCostOfDoingNothing-1.0-SNAPSHOT.jar com.yahoo.jmh.jmhtest.JavaTest
```

```
java -Djava.library.path=target/native/x86_64-linux-gcc/ -jar target/JavaTheCostOfDoingNothing-1.0-SNAPSHOT.jar com.yahoo.jmh.jmhtest.JNITest
```

=== HW Config
```
Summary:	HP DL160 G6, 2 x Xeon E5620 2.40GHz, 23.1GB / 24GB 1333MHz DDR3, 1 x 1TB SATA
System:		HP ProLiant DL160 G6, C-2N/24/1000, ySPEC 25.0
Processors:	2 x Xeon E5620 2.40GHz, 4.80GT QPI (HT enabled, 8 cores, 16 threads) - Gulftown B1, 64-bit, quad-core, 32nm, L3: 12MB
Memory:		23.1GB / 24GB 1333MHz DDR3 == 6 x 4GB - 4GB PC3-10600 Hynix DDR3-1333 ECC Registered CL9 1Rx4
		                              12 x empty
Disk:		sda (ahci0): 1.0TB (0%) JBOD == 1 x 1TB 7.2K SATA/300 Hitachi Ultrastar A7K2000 32MB
Disk-Control:	ahci0: HP/Intel ICH10 82801J 6 Port SATA/300 AHCI
Chipset:	Intel 5520 IOH-36D B3 (Tylersburg), 82801JIR A0 (ICH10R)
Network:	eth0 (igb): HP NC362i/Intel 82576 Gigabit, 1Gb/s <full-duplex>
Network:	eth1 (igb): HP NC362i/Intel 82576 Gigabit, no carrier
OS:		RHEL 6.5.7, RHEL Server 6.5, Linux 2.6.32-431.23.3.el6.YAHOO.20140804.x86_64 x86_64, 64-bit
BIOS:		HP O33 09/01/2011, rev 8.15
```

=== data
```
jnitest.txt
javatest.txt
```
