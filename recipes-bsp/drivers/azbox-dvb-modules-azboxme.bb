require azbox-dvb-modules.inc

COMPATIBLE_MACHINE = "^(azboxme)$"

SRCDATE = "17092013"

SRC_URI = "http://source.mynonpublic.com/azbox/${MACHINE}-dvb-modules-${KV}-oe-core-${SRCDATE}.tar.gz"

SRC_URI[md5sum] = "3d7b8d240626a08f16c170e5832be618"
SRC_URI[sha256sum] = "48b48a94094ecce34398efcee7e17e780d9cce0ecf1510758078ed4e18f9ce6d"

do_install() {
    install -d ${D}${base_libdir}/modules/${KV}/extra
    install -d ${D}/${sysconfdir}/modules-load.d
    for i in llad em8xxx 865xi2c avl6211 avl2108 mxl241sf nimdetect sci 865xdvb; do
        install -m 0755 ${WORKDIR}/$i.ko ${D}${base_libdir}/modules/${KV}/extra
        echo $i >> ${D}/${sysconfdir}/modules-load.d/_${MACHINE}.conf
    done
    install -d ${D}/lib/firmware
    install -m 0644 ${WORKDIR}/dvb-fe-avl2108.fw ${D}/lib/firmware/dvb-fe-avl2108.fw
    install -m 0644 ${WORKDIR}/dvb-fe-avl2108-blind.fw ${D}/lib/firmware/dvb-fe-avl2108-blind.fw
    install -m 0644 ${WORKDIR}/dvb-fe-avl6211.fw ${D}/lib/firmware/dvb-fe-avl6211.fw
}
