#!/usr/bin/python

import sys

lastkey, maxval = None, -sys.maxint
for line in sys.stdin:
    (key, val) = line.strip().split("\t")
    if lastkey and lastkey != key:
        print ("%s\t%s" % (lastkey, maxval))
        (lastkey, maxval) = (key, int(val))
    else:
        (lastkey, maxval) = (key, max(maxval, int(val)))
if lastkey:
    print ("%s\t%s" % (lastkey, maxval))
