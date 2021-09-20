package cn.chat.ui.view.register;

import cn.chat.ui.view.UIObject;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * @ClassName：RegisterInit
 * @Description: 注册初始化
 * @Author：13738700108
 * @Data 2021/9/20 14:37
 * @Version: v1.0
 **/
public abstract class RegisterInit extends UIObject {

    private static final String RESOURCE_NAME = "/fxml/register/register.fxml";

    protected IRegisterEvent iRegisterEvent;

    public RegisterInit(IRegisterEvent iRegisterEvent) {
        this.iRegisterEvent = iRegisterEvent;
        try {
            root = FXMLLoader.load(getClass().getResource(RESOURCE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        setScene(scene);
        initStyle(StageStyle.TRANSPARENT);
        setResizable(false);
        // 模态窗口
        initModality(Modality.NONE);
        // 初始化页面&事件
        obtain();
        initView();
        initEventDefine();
    }

    protected void obtain(){

    }
}
