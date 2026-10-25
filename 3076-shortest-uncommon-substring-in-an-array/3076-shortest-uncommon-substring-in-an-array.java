class Solution {
    public String[] shortestSubstrings(String[] arr) {
        Map<String,Integer> map = new HashMap<>();
        for(String s : arr)
            {
                int n = s.length();
                Set<String> set = new HashSet<>();
                for(int i=0;i<n;i++)
                    {
                        for(int j=i+1;j<=n;j++)
                            {
                                String str = s.substring(i,j);
                                set.add(str);
                                
                            }
                    }
                    for(String t : set)
                    {
                        map.put(t,map.getOrDefault(t,0)+1);
                    }
            }
        int idx=0;
        for(String s : arr)
            {
                arr[idx]="";
                int n = s.length();
                List<String> list = new ArrayList<>();
                for(int i=0;i<n;i++)
                    {
                        for(int j=i+1;j<=n;j++)
                            {
                                String str = s.substring(i,j);
                                if(map.get(str)==1)
                                {
                                     list.add(str);
                                }
                            }
                    }
                if(list.size()!=0)
                {
                list.sort((a,b)-> {
                    if(a.length()!=b.length())
                    {
                        return a.length()-b.length();
                    }
                    return a.compareTo(b);
                });
                arr[idx]=list.get(0);
                }
                idx++;
            }
        return arr;
    }
}