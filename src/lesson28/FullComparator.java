package lesson28;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        if (o1.getChannelName() == null || o1.getFingerprint() == null)
            return 1;
        else if (o2.getChannelName() == null || o2.getFingerprint() == null)
            return -1;
        if (!o1.getChannelName().equals(o2.getChannelName())) {
            return o1.getChannelName().compareTo(o2.getChannelName());
        }
        if (!o1.getFingerprint().equals(o2.getFingerprint()))
            return o1.getFingerprint().compareTo(o2.getFingerprint());
        else {
            DateComparator dateComparator = new DateComparator();
            return dateComparator.compare(o1, o2);
        }
    }
}
