/*
THIS IS A GENERATED/BUNDLED FILE BY ROLLUP
if you want to view the source visit the plugins github repository
*/

'use strict';

var obsidian = require('obsidian');

/*! *****************************************************************************
Copyright (c) Microsoft Corporation.

Permission to use, copy, modify, and/or distribute this software for any
purpose with or without fee is hereby granted.

THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES WITH
REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF MERCHANTABILITY
AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY SPECIAL, DIRECT,
INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES WHATSOEVER RESULTING FROM
LOSS OF USE, DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR
OTHER TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR
PERFORMANCE OF THIS SOFTWARE.
***************************************************************************** */
/* global Reflect, Promise */

var extendStatics = function(d, b) {
    extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
    return extendStatics(d, b);
};

function __extends(d, b) {
    if (typeof b !== "function" && b !== null)
        throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
    extendStatics(d, b);
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
}

var imageExt = ["bmp", "png", "jpg", "jpeg", "gif", "svg"];
var audioExt = ["mp3", "wav", "m4a", "3gp", "flac", "ogg", "oga"];
var videoExt = ["mp4", "webm", "ogv"];
function isInternalEmbed(node) {
    var _a;
    if (node.nodeType === 3) {
        return false;
    }
    var child = node.firstChild;
    return child && ((_a = child.classList) === null || _a === void 0 ? void 0 : _a.contains("internal-embed"));
}
function getEmbedType(node) {
    if (node.nodeType === 3) {
        return null;
    }
    var child = node.firstChild;
    var src = child.getAttr("src");
    if (!src) {
        return null;
    }
    var ext = src.split(".").pop();
    if (imageExt.contains(ext))
        return "image";
    if (audioExt.contains(ext))
        return "audio";
    if (videoExt.contains(ext))
        return "video";
    if (/#\^[^\^]+$/.test(src))
        return "block";
    if (/#[^#]+$/.test(src))
        return "heading";
    return "page";
}
function isExternalImageEmbed(node) {
    var _a;
    if (node.nodeType === 3) {
        return false;
    }
    var child = node.firstChild;
    return child && ((_a = child.tagName) === null || _a === void 0 ? void 0 : _a.toLowerCase()) === "img";
}
function getBlockLanguage(node) {
    if (node.nodeType === 3) {
        return null;
    }
    var lang = null;
    node.classList.forEach(function (cls) {
        if (cls.startsWith("block-language")) {
            lang = cls.replace(/^block\-language\-/, "");
        }
    });
    return lang;
}
function fixMarkdownLinkEmbeds(node) {
    if (node.children.length <= 1) {
        return;
    }
    var containsNakedEmbed = false;
    var childNodes = [];
    node.childNodes.forEach(function (n) {
        var _a;
        if (n.nodeValue === "\n")
            return;
        switch (n.nodeName) {
            case "P": {
                if (n.children.length === 0) {
                    return;
                }
                else {
                    n.childNodes.forEach(function (pn) {
                        if (pn.nodeName !== "BR" && pn.nodeValue !== "\n")
                            childNodes.push(pn);
                    });
                    return;
                }
            }
            case "BR": {
                return;
            }
        }
        if (n.nodeType === 1 &&
            ((_a = n.classList) === null || _a === void 0 ? void 0 : _a.contains("internal-embed"))) {
            containsNakedEmbed = true;
        }
        childNodes.push(n);
    });
    if (!containsNakedEmbed)
        return;
    node.empty();
    node.createEl("p", {}, function (p) {
        childNodes.forEach(function (c, i, arr) {
            var _a;
            p.append(c);
            var nodeIsEmbed = c.nodeType === 1 &&
                !!c.getAttribute("src") &&
                i < arr.length - 1;
            var nodeIsTextFollowedByEmbed = c.nodeType === 3 &&
                ((_a = arr[i + 1]) === null || _a === void 0 ? void 0 : _a.nodeType) === 1 &&
                !!arr[i + 1].getAttribute("src");
            if (nodeIsEmbed || nodeIsTextFollowedByEmbed) {
                p.createEl("br");
            }
        });
    });
}
function tagNode(node, ctx) {
    if (node.nodeType === 3) {
        return;
    }
    var nodeEl = node;
    var isPrint = nodeEl.hasClass("markdown-preview-view");
    fixMarkdownLinkEmbeds(nodeEl);
    if (!isPrint &&
        !nodeEl.dataset.tagName &&
        nodeEl.hasChildNodes() &&
        nodeEl.firstChild.nodeType !== 3) {
        var childEl_1 = node.firstChild;
        Object.keys(childEl_1.dataset).forEach(function (k) { return (nodeEl.dataset[k] = childEl_1.dataset[k]); });
        nodeEl.findAll("a.tag").forEach(function (tagEl) {
            var tag = tagEl.innerText
                .slice(1)
                .replace("/", "");
            nodeEl.addClass("tag-" + tag);
        });
        var tagName = childEl_1.tagName.toLowerCase();
        if (isExternalImageEmbed(childEl_1)) {
            nodeEl.dataset.isEmbed = "true";
            nodeEl.dataset.embedType = "image";
            nodeEl.addClass("el-embed-image");
        }
        else if (isInternalEmbed(childEl_1)) {
            var embedType = getEmbedType(childEl_1);
            nodeEl.dataset.isEmbed = "true";
            nodeEl.dataset.embedType = embedType;
            nodeEl.addClass("el-embed-" + embedType);
        }
        else {
            var blockLang = getBlockLanguage(childEl_1);
            if (blockLang) {
                nodeEl.dataset.blockLanguage = blockLang;
                nodeEl.addClass("el-lang-" + blockLang);
            }
        }
        nodeEl.dataset.tagName = tagName;
        nodeEl.addClass("el-" + tagName);
    }
    else if (isPrint && nodeEl.children.length > 0) {
        var children = nodeEl.children;
        var _loop_1 = function (i) {
            var child = children[i];
            child.findAll("a.tag").forEach(function (tagEl) {
                var tag = tagEl.innerText
                    .slice(1)
                    .replace("/", "");
                child.addClass("tag-" + tag);
            });
        };
        for (var i = 0; i < children.length; i++) {
            _loop_1(i);
        }
    }
}
var ContextualTypography = /** @class */ (function (_super) {
    __extends(ContextualTypography, _super);
    function ContextualTypography() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    ContextualTypography.prototype.onload = function () {
        document.body.classList.add("contextual-typography");
        this.registerMarkdownPostProcessor(tagNode);
    };
    ContextualTypography.prototype.unload = function () {
        document.body.classList.remove("contextual-typography");
    };
    return ContextualTypography;
}(obsidian.Plugin));

module.exports = ContextualTypography;
//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWFpbi5qcyIsInNvdXJjZXMiOlsibm9kZV9tb2R1bGVzL3RzbGliL3RzbGliLmVzNi5qcyIsInNyYy9tYWluLnRzIl0sInNvdXJjZXNDb250ZW50IjpudWxsLCJuYW1lcyI6WyJQbHVnaW4iXSwibWFwcGluZ3MiOiI7Ozs7Ozs7OztBQUFBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0EsSUFBSSxhQUFhLEdBQUcsU0FBUyxDQUFDLEVBQUUsQ0FBQyxFQUFFO0FBQ25DLElBQUksYUFBYSxHQUFHLE1BQU0sQ0FBQyxjQUFjO0FBQ3pDLFNBQVMsRUFBRSxTQUFTLEVBQUUsRUFBRSxFQUFFLFlBQVksS0FBSyxJQUFJLFVBQVUsQ0FBQyxFQUFFLENBQUMsRUFBRSxFQUFFLENBQUMsQ0FBQyxTQUFTLEdBQUcsQ0FBQyxDQUFDLEVBQUUsQ0FBQztBQUNwRixRQUFRLFVBQVUsQ0FBQyxFQUFFLENBQUMsRUFBRSxFQUFFLEtBQUssSUFBSSxDQUFDLElBQUksQ0FBQyxFQUFFLElBQUksTUFBTSxDQUFDLFNBQVMsQ0FBQyxjQUFjLENBQUMsSUFBSSxDQUFDLENBQUMsRUFBRSxDQUFDLENBQUMsRUFBRSxDQUFDLENBQUMsQ0FBQyxDQUFDLEdBQUcsQ0FBQyxDQUFDLENBQUMsQ0FBQyxDQUFDLEVBQUUsQ0FBQztBQUMxRyxJQUFJLE9BQU8sYUFBYSxDQUFDLENBQUMsRUFBRSxDQUFDLENBQUMsQ0FBQztBQUMvQixDQUFDLENBQUM7QUFDRjtBQUNPLFNBQVMsU0FBUyxDQUFDLENBQUMsRUFBRSxDQUFDLEVBQUU7QUFDaEMsSUFBSSxJQUFJLE9BQU8sQ0FBQyxLQUFLLFVBQVUsSUFBSSxDQUFDLEtBQUssSUFBSTtBQUM3QyxRQUFRLE1BQU0sSUFBSSxTQUFTLENBQUMsc0JBQXNCLEdBQUcsTUFBTSxDQUFDLENBQUMsQ0FBQyxHQUFHLCtCQUErQixDQUFDLENBQUM7QUFDbEcsSUFBSSxh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
