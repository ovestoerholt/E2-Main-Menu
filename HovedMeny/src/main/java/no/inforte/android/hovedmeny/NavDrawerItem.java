package no.inforte.android.hovedmeny;

/**
 * Created by ove on 16.10.13.
 */
public interface NavDrawerItem {
    public int getId();
    public String getLabel();
    public int getType();
    public boolean isEnabled();
    public boolean updateActionBarTitle();
}