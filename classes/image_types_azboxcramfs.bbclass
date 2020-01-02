inherit image_types

IMAGE_CMD_azboxcramfs = "mkfs.cramfs ${IMAGE_ROOTFS} ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.cramfs;"

do_image_azboxcramfs[depends] += "cramfs-native:do_populate_sysroot"

IMAGE_TYPES += "cramfs"
