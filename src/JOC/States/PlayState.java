package JOC.States;
import JOC.Collision.ColissionChecker;
import JOC.Items.Baiat;
import JOC.RefLinks;
import JOC.Maps.Map;

import java.awt.*;
public class PlayState extends State{

    public static Map map;
    public static ColissionChecker cChecker;
    public static Baiat baiat;
    public PlayState(RefLinks refLink)
    {
        super(refLink);

        map = new Map(refLink);
       
        refLink.SetMap(map);

        cChecker = new ColissionChecker(this);

        baiat = Baiat.getInstance(refLink,20, 380);
    }
    @Override
    public void Update()
    {
        map.Update();
        baiat.Update();
    }
    @Override
    public void Draw(Graphics g)
    {
        map.Draw(g);
        baiat.Draw(g);
    }
}
