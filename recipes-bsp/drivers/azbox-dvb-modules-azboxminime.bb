require azbox-dvb-modules.inc

COMPATIBLE_MACHINE = "^(azboxminime)$"

SRCDATE = "17092013"

SRC_URI = "http://source.mynonpublic.com/azbox/${MACHINE}-dvb-modules-${KV}-oe-core-${SRCDATE}.tar.gz"

SRC_URI[md5sum] = "2c037462af10a7909f4c803a90b82a1d"
SRC_URI[sha256sum] = "7ac3c8ac567ffe627850fda0c6713dce71305886af6e3cc286800fbfc394709a"

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
