IMAGE_INSTALL_remove = " \
	${@bb.utils.contains("MACHINE_FEATURES", "azbox", "\
	ofgwrite \
	", "", d)} \
	"

IMAGE_INSTALL_remove_azboxhd = " \
	samba-base \
	"
