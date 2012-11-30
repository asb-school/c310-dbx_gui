package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.Npc;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2012-11-30T02:58:25")
@StaticMetamodel(NpcType.class)
public class NpcType_ { 

    public static volatile SingularAttribute<NpcType, Integer> id;
    public static volatile CollectionAttribute<NpcType, Npc> npcCollection;
    public static volatile SingularAttribute<NpcType, Float> aggressiveness;
    public static volatile SingularAttribute<NpcType, Float> benevolence;
    public static volatile SingularAttribute<NpcType, String> name;

}