require azbox-dvb-modules.inc

COMPATIBLE_MACHINE = "^(azboxhd)$"

SRCDATE = "19092013"

SRC_URI = "file://${MACHINE}-dvb-modules-${KV}-oe-core-${SRCDATE}.tar.gz"

SRC_URI[md5sum] = "0e9f349735ecae61fd9db76ea0da9985"
SRC_URI[sha256sum] = "c12bf66416d1faf4c3efb35b590f02ee0c255879d057fa553fb95037138c2d75"

do_install() {
    install -d ${D}${nonarch_base_libdir}/modules/${KV}/extra
    install -d ${D}${sysconfdir}/modules-load.d
    for i in llad em8xxx 863xi2c az_cx24116 az_mxl201rf az_mxl5007t az_stv6110x az_stv090x az_tda10023 az_zl10353 nimdetect sci 863xdvb; do
        install -m 0755 ${WORKDIR}/$i.ko ${D}${nonarch_base_libdir}/modules/${KV}/extra
        echo $i >> ${D}${sysconfdir}/modules-load.d/_${MACHINE}.conf
    done
    install -d ${D}${nonarch_base_libdir}/firmware
    install -m 0644 ${WORKDIR}/dvb-fe-cx24116.fw ${D}${nonarch_base_libdir}/firmware/dvb-fe-cx24116.fw
}
