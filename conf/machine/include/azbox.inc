# We know about rtc
MACHINE_FEATURES_BACKFILL_CONSIDERED += "rtc"

KERNELVERSION = "3.9.2"

BOX_BRAND = "azbox"

MACHINE_ESSENTIAL_EXTRA_RDEPENDS += "\
	azbox-compat \
	azbox-dvb-modules-${MACHINE} \
	azbox-mrua-${MACHINE} \
	enigma2-plugin-systemplugins-rtisys \	
	enigma2-plugin-systemplugins-videosettingssetup \
	"

EXTRA_IMAGEDEPENDS += "\
	kmod-native \
	"

DVBPROVIDER = "kernel"

DVBMEDIASINK_CONFIG = "--with-wma --with-wmv --with-pcm --with-dtsdownmix"

MACHINE_FEATURES += "azbox alsa usbhost nl80211 switchoff lpcm textlcd 32bpp dvbapi5 dvb-c blindscan-dvbs HDMI"

PREFERRED_PROVIDER_virtual/kernel = "linux-azbox"
PREFERRED_VERSION_linux-azbox = "${KERNELVERSION}"
PREFERRED_PROVIDER_virtual/blindscan-dvbs = "azbox-blindscan-dvbs-utils"

GLIBC_EXTRA_OECONF = "--with-tls --with-__thread"

require conf/machine/include/tune-mips32.inc
require conf/machine/include/soc-family.inc

SYSVINIT_ENABLED_GETTYS = ""

BLINDSCAN_BINARY = "avl_azbox_blindscan"
