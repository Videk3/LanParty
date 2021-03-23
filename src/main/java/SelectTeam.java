import javax.swing.*;
import java.util.ArrayList;

public class SelectTeam {
    private JPanel panel;
    private JList teamsList;
    private JComboBox gameComboBox;
    private JLabel label1;
    private JButton joinTeamButton;
    private User user;

    public SelectTeam(User uuser){
        fillComboBox();
        setActionListeners();
        user = uuser;
    }


    private void setActionListeners() {
        gameComboBox.addActionListener(e -> showTeams());

        joinTeamButton.addActionListener(e -> {
            int teamId = Database.GetTeamId(teamsList.getName());
            //Database.JoinTeam(teamId, user);
         });
    }

    private void fillComboBox(){
        ArrayList<String> games =  Database.GetGames();

        DefaultComboBoxModel<String> demoList = new DefaultComboBoxModel<>();

        for (String game: games
        ) {
            demoList.addElement(game);
        }
        gameComboBox.setModel(demoList);

        System.out.println("games demoList: " + demoList);
    }

    private void showTeams(){
        String gameName = gameComboBox.getSelectedItem().toString();

        ArrayList<String> teams =  Database.GetTeams(gameName);

        DefaultListModel<String> demoList = new DefaultListModel<>();

        for (String team: teams
        ) {
            demoList.addElement(team);
        }
        //teamsList = new JList(demoList);
        teamsList.setModel(demoList);

        //System.out.println("teams demoList: " + demoList);
    }

}
