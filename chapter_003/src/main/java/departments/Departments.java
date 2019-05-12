package departments;

import java.util.*;

public class Departments {

    public static final class Org implements Comparable<Org> {

        public static final class OrgComparator implements Comparator<Org> {
            @Override
            public int compare(Org o1, Org o2) {
                int len = Math.min(o2.deps.size(), o1.deps.size());
                int result = 0;
                for (int i = 0; i < len; i++) {
                    result = o1.deps.get(i).compareTo(o2.deps.get(i));
                    if (result != 0) {
                        break;
                    }
                }
                if (result == 0) {
                    result = o1.deps.size() - o2.deps.size();
                }
                return result;
            }

            @Override
            public Comparator<Org> reversed() {
                return new Comparator<Org>() {
                    @Override
                    public int compare(Org o1, Org o2) {
                        int result;
                        if ((o1.deps.size() == 1 || o2.deps.size() == 1) && o1.deps.get(0).equals(o2.deps.get(0))) {
                            result = o1.deps.size() - o2.deps.size();
                        } else {
                            result = o2.compareTo(o1);
                        }
                        return result;
                    }
                };
            }
        }

        private final List<String> deps;

        public Org(List<String> deps) {
            this.deps = deps;
        }

        @Override
        public int compareTo(Org o) {
            OrgComparator c = new OrgComparator();
            return c.compare(this, o);
        }

        @Override
        public int hashCode() {
            return deps.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return (obj != null && obj.getClass().equals(this.getClass()) && this.deps.equals(((Org) obj).deps));
        }

        @Override
        public String toString() {
            return deps.toString();
        }

    }

    public List<Org> convert(List<String> deps) {
        List<Org> result = new ArrayList<>();
        for (String dep : deps) {
            List<String> items = Arrays.asList(dep.split("/"));
            for (int i = 1; i <= items.size(); i++) {
                Org org = new Org(items.subList(0, i));
                if (!result.contains(org)) {
                    result.add(org);
                }
            }
        }
        return result;
    }

    public List<Org> sortAsc(List<Org> orgs) {
        List<Org> result = new ArrayList<>(orgs);
        Collections.sort(result);
        return result;
    }

    public List<Org> sortDesc(List<Org> orgs) {
        List<Org> result = sortAsc(orgs);
        Collections.sort(result, new Org.OrgComparator().reversed());
        return result;
    }
}