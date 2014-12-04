package hello;

import static org.kuali.common.util.base.Precondition.checkMin;
import static org.kuali.common.util.base.Precondition.checkNotBlank;

public final class Greeting {

    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = checkMin(id, 1, "id");
        this.content = checkNotBlank(content, "content");
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}