#!/bin/sh
for a in *.txt;do tail -10 $a;done  | awk '{OFMT="%2.3f"; CONVFMT="%2.3f"; L=($4-$7); U=($4+$7);print $1"\t"$2"\t"$3"\t"$4"\t"$5"\t"$6"\t"$7"\t"L"\t"U}'
