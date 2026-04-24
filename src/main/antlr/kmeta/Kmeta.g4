grammar Kmeta;

// Parser Rules
kmeta_file
    : type_definition* EOF
    ;

type_definition
    : TYPE STRING STRING LBRACE rule_list? RBRACE
    ;

rule_list
    : rule+
    ;

rule
    : prop_rule
    | has_rule
    | knows_rule
    ;

prop_rule
    : PROP LPAREN STRING COMMA rule_value RPAREN
    ;

has_rule
    : HAS LPAREN STRING COMMA rule_value RPAREN
    ;

knows_rule
    : KNOWS LPAREN STRING COMMA rule_value RPAREN
    ;

rule_value
    : STRING
    | LIST LPAREN STRING RPAREN
    ;

// Lexer Rules
TYPE     : 'type' ;
PROP     : 'prop' ;
HAS      : 'has' ;
KNOWS    : 'knows' ;
LIST     : 'list' ;

LBRACE   : '{' ;
RBRACE   : '}' ;
LPAREN   : '(' ;
RPAREN   : ')' ;
COMMA    : ',' ;

STRING   : '"' ( '\\' . | ~["\r\n] )* '"' ;

WS       : [ \t\r\n]+ -> skip ;



