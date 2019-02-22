package dmitry.borodin.console.game.model;

import java.util.ArrayList;
import java.util.List;

public class LoadGameContext extends ReturnContext {

    private static final int USERS_PER_PAGE = 10;
    private List<String> users = new ArrayList<>();
    private int currentPage;

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public boolean hasNextPage() {
        return users.size() > (currentPage + 1) * USERS_PER_PAGE;
    }


    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return USERS_PER_PAGE;
    }

    public void nextPage() {
        if (hasNextPage()) {
            currentPage++;
        }
    }

    public void prevPage() {
        if (currentPage > 0) {
            currentPage--;
        }
    }

    public int getTotalCount() {
        return users.size();
    }

    public List<String> getCurrentPageUsers() {
        int from = currentPage * USERS_PER_PAGE;
        int to = Math.min(users.size(), from + USERS_PER_PAGE);
        return users.subList(from, to);
    }

    public String getGame(int selectedGame) {
        return users.get(selectedGame);
    }

}
