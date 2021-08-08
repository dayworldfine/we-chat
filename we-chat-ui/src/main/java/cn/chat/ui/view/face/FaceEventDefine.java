package cn.chat.ui.view.face;

/**
 * @ClassName：
 * @Description:
 * @Author：13738700108
 * @Data 2021/8/8 9:43
 * @Version: v1.0
 **/
public class FaceEventDefine {

    private FaceInit faceInit;

    public FaceEventDefine(FaceInit faceInit) {
        this.faceInit = faceInit;

        hideFace();
    }

    private void hideFace(){
        faceInit.root().setOnMouseExited(event -> {
            faceInit.hide();
        });
    }

}
