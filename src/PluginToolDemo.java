import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

/**
 * @Description:
 * @author: york
 * @date: 2017-01-11 18:07
 * @version: v1.0
 */
public class PluginToolDemo extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        PluginToolDemoDialog dialog = new PluginToolDemoDialog();
        dialog.pack();
        dialog.setVisible(true);
        dialog.setSize(800,400);
    }
}
