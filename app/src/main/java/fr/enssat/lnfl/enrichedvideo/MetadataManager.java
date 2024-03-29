package fr.enssat.lnfl.enrichedvideo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Omar et Thibault on 20/12/2017.
 */

public class MetadataManager {
    private List<Metadata> lMetadata;
    public MetadataManager(){
        this.lMetadata = new LinkedList<>();
    }

    public void add(Metadata metadata){
        this.lMetadata.add(metadata);
    }

    public void add(int _msPosition,String _context, String _url){
        this.lMetadata.add(new Metadata(_msPosition,_context,_url));
    }

    public int getPositionByContext(String context){
        for (Metadata m:this.lMetadata){
            if(m.getContext()==context){
                return m.getSPosition();
            }
        }
        return -1;
    }

    public String getContextByPosition(int position){
        Metadata resMetadata = this.lMetadata.get(0);
        for (Metadata m:this.lMetadata){
            if(resMetadata.getSPosition() < m.getSPosition() && position > m.getSPosition()){
                resMetadata = m;
            }
        }
        return resMetadata.getContext();
    }

    public String getUrlByPosition(int position){
        Metadata resMetadata = this.lMetadata.get(0);
        for (Metadata m:this.lMetadata){
            if(resMetadata.getSPosition() < m.getSPosition() && position > m.getSPosition()){
                resMetadata = m;
            }
        }
        return resMetadata.getUrl();
    }
}
