package com.madv.duel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class AbstractStrategy  {

    public abstract Integer makeAttackingMove(Desk deskOwn, Desk deskForeign) ;
    public abstract Integer makeDefensiveMove(Desk deskOwn, Desk deskForeign) ;
}
