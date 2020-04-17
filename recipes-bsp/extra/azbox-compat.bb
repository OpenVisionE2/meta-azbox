SUMMARY = "AZBox compatibility links"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"

require conf/license/license-close.inc

PV = "1.0"

do_install() {
    install -d ${D}/lib
    ln -sf libgcc_s.so.1 ${D}/lib/libgcc_s_nof.so.1
    install -d ${D}${libdir}
    ln -sf libpython2.7.so.1.0 ${D}${libdir}/libpython2.6.so.1.0
    ln -sf libgif.so.7 ${D}${libdir}/libungif.so.4
}

PACKAGES = "${PN}"
