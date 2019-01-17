import java.util.Stack;

/**
 * Created by tina on 2019/1/17.
 */
public class BrowserGoFrontAndBack {
    private Stack<String> stackSite;
    private Stack<String> stackBackup;

    public BrowserGoFrontAndBack(){
        stackSite = new Stack<String>();
        stackBackup = new Stack<String>();
    }

    public void gotoSite(String siteURL) {
        stackSite.push(siteURL);
        stackBackup.clear();
    }

    public void goBack() {
        if (!stackSite.isEmpty()) {
            stackBackup.push(stackSite.pop());
        }
    }

    public void goFront() {
        if (!stackBackup.isEmpty()) {
            stackSite.push(stackBackup.pop());
        }
    }

    public void close() {
        stackBackup.clear();
        stackSite.clear();
    }

    public String get() {
        if (stackSite.isEmpty()){
            return "";
        }
        return stackSite.peek();
    }

    public boolean canGoFront() {
        return !stackBackup.isEmpty();
    }

    public boolean canGoBack() {
        return !stackSite.isEmpty();
    }
}
