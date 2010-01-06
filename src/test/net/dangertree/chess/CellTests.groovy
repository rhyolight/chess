package net.dangertree.chess

class CellTests extends GroovyTestCase {
    
    void testSetDescriptorTranslatesIntoXY() {
        def c = new Cell(descriptor:'A1')
        assertEquals 0, c.x
        assertEquals 0, c.y
    }
    
    void testGetDescriptorTranslationFromXY() {
        def c = new Cell(x:0, y:0)
        assertEquals('A1', c.descriptor)
    }
}