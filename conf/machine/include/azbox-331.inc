# We know about rtc
include conf/machine/include/build-extras.inc

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
    azbox-dvb-modules-331 \
    "

DVBPROVIDER = "kernel"

MACHINE_EXTRA_RRECOMMENDS += "\
    azbox-compat \
    azbox-mrua \
    "

DVBMEDIASINK_CONFIG = "--with-wma --with-wmv --with-pcm --with-dtsdownmix --with-azbox"

MACHINE_FEATURES += " azbox alsa usbhost wifi nl80211 3dtv switchoff lpcm textlcd 32bpp hdtv dvbapi5 dvb-c blindscan-dvbs"

PREFERRED_PROVIDER_virtual/kernel = "linux-azbox"
PREFERRED_VERSION_linux-azbox = "3.3.1"
PREFERRED_PROVIDER_virtual/blindscan-dvbs = "azbox-blindscan-dvbs-utils"
PREFERRED_VERSION_rt8812au = "4.3.14"

GLIBC_EXTRA_OECONF = "--with-tls --with-__thread"

require conf/machine/include/tune-mips32.inc
require conf/machine/include/soc-family.inc
include conf/machine/include/autoload-filesystems.inc

SYSVINIT_ENABLED_GETTYS = ""
